import pandas as pd

# 1. Load cleaned dataset
df = pd.read_csv("data/cleaned_comments.csv")

# 2. Keep only rows where label is NOT empty
df_labeled = df[df['label'].notna()]

# 3. Convert label to integer (0 or 1)
df_labeled['label'] = df_labeled['label'].astype(int)

# 4. Keep only the needed columns
df_final = df_labeled[['clean_text', 'label']]

# 5. Save to a new CSV
df_final.to_csv("data/labeled_dataset.csv", index=False)

print("Saved -> data/labeled_dataset.csv")
print(df_final.head())
print("Total labeled samples:", len(df_final))
