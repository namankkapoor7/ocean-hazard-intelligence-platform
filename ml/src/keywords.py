import pandas as pd
from keybert import KeyBERT

def extract_keywords(text, kw_model, top_n=5):
    try:
        keywords = kw_model.extract_keywords(
            text,
            keyphrase_ngram_range=(1, 2),
            stop_words='english',
            top_n=top_n
        )
        return ", ".join([kw[0] for kw in keywords])
    except:
        return ""

if __name__ == "__main__":
    
    # Load input dataset
    df = pd.read_csv("data/labeled_dataset.csv", encoding="latin1")

    # Only keep clean_text
    df = df[['clean_text']].dropna()

 
    # Initialize model
    print("Loading KeyBERT model...")
    kw_model = KeyBERT()

   
    # Extract keywords
    print("Extracting keywords...")
    df['keywords'] = df['clean_text'].apply(lambda x: extract_keywords(x, kw_model))

    
    # Save final output
    output_path = "data/keywords_output.csv"
    df.to_csv(output_path, index=False, encoding="utf-8")

    print(f"\nSaved: {output_path}")
    print(df.head())
