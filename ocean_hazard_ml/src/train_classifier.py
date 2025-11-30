import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import classification_report, accuracy_score
import joblib
import csv


# Load dataset 
df = pd.read_csv("data/labeled_dataset.csv", encoding="latin1")


# Keep only necessary columns
df = df[['clean_text', 'label']].dropna()

X = df['clean_text']
y = df['label'].astype(int)


# Train-test split
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.2, random_state=42, stratify=y
)


# Vectorization (Improved TF-IDF)
vectorizer = TfidfVectorizer(
    max_features=7000,
    ngram_range=(1, 2),
    stop_words='english',
    sublinear_tf=True        # improves performance
)

X_train_vec = vectorizer.fit_transform(X_train)
X_test_vec = vectorizer.transform(X_test)


# Train classifier 
# class_weight='balanced' fixes imbalance issues
model = LogisticRegression(
    max_iter=1000,
    class_weight='balanced',
    C=2.0,                    # stronger regularization
    solver='liblinear'        # stable for small datasets
)

model.fit(X_train_vec, y_train)


# Evaluate
y_pred = model.predict(X_test_vec)

accuracy = accuracy_score(y_test, y_pred)
report = classification_report(y_test, y_pred, output_dict=True)

print("Accuracy:", accuracy)
print("\nClassification Report:\n", classification_report(y_test, y_pred))


# Save results to CSV


results_file = "data/training_metrics.csv"

with open(results_file, "w", newline='', encoding='utf-8') as f:
    writer = csv.writer(f)
    
    writer.writerow(["Metric", "Value"])
    writer.writerow(["Accuracy", accuracy])
    
    writer.writerow([])
    writer.writerow(["Class", "Precision", "Recall", "F1-Score", "Support"])
    
    for cls, metrics in report.items():
        if cls not in ["accuracy", "macro avg", "weighted avg"]:
            writer.writerow([
                cls,
                metrics["precision"],
                metrics["recall"],
                metrics["f1-score"],
                metrics["support"]
            ])
    
    # Add macro + weighted averages
    writer.writerow([])
    writer.writerow(["macro avg",
                     report["macro avg"]["precision"],
                     report["macro avg"]["recall"],
                     report["macro avg"]["f1-score"],
                     report["macro avg"]["support"]])
    
    writer.writerow(["weighted avg",
                     report["weighted avg"]["precision"],
                     report["weighted avg"]["recall"],
                     report["weighted avg"]["f1-score"],
                     report["weighted avg"]["support"]])

print(f"\n✔ Metrics saved to {results_file}")


# Save model & vectorizer
joblib.dump(model, "models/hazard_classifier.pkl")
joblib.dump(vectorizer, "models/tfidf_vectorizer.pkl")

print("\n✔ Model and vectorizer saved!")
