import yt_dlp
import pandas as pd
import os
import sys

# 🔥 CRITICAL FIX: Force standard output and error streams to use UTF-8 encoding
# This prevents the UnicodeEncodeError when printing the checkmark (✔)
sys.stdout.reconfigure(encoding='utf-8')
sys.stderr.reconfigure(encoding='utf-8')

# --- CRITICAL FIX: Define the ABSOLUTE output path ---
OUTPUT_FILE_PATH = "C:\\Users\\navee\\Desktop\\MiniProject\\ocean_hazard_ml\\data\\youtube_comments.csv" 

# FUNCTION TO SCRAPE COMMENTS
def get_comments(video_url, limit=600):
    ydl_opts = {
        "extract_flat": True,
        "skip_download": True,
        "getcomments": True,
    }

    print(f"Scraping comments from: {video_url}")

    with yt_dlp.YoutubeDL(ydl_opts) as ydl:
        try:
            info = ydl.extract_info(video_url, download=False)
        except Exception as e:
            # Print to standard error so Java can capture the error stream
            print(f"Error scraping {video_url}: {e}", file=os.sys.stderr) 
            return pd.DataFrame()

    if "comments" not in info:
        print("No comments found for:", video_url, file=os.sys.stderr)
        return pd.DataFrame()

    comments = []
    count = 0

    for c in info["comments"]:
        if count >= limit:
            break

        comments.append({
            "text": c.get("text", ""), 
            "video_url": video_url,
            "author": c.get("author", ""),
            "likes": c.get("like_count", 0),
            "time": c.get("time_text", "")
        })

        count += 1

    # This print statement now works without crashing!
    print(f"✔ Extracted {len(comments)} comments from {video_url}")
    return pd.DataFrame(comments)

if __name__ == "__main__": 

    video_links = [
        "https://www.youtube.com/watch?v=MUC5kNCMetY",
        "https://www.youtube.com/watch?v=kLmopK-qDwk",
        "https://www.youtube.com/watch?v=Cys8581RSXE",
        "https://www.youtube.com/watch?v=UZecnRSnOdg"
    ]

    all_comments = []

    for url in video_links:
        df = get_comments(url, limit=50) 
        all_comments.append(df)

    combined_df = pd.concat(all_comments, ignore_index=True)
    combined_df.drop_duplicates(subset=["text"], inplace=True)

    OUTPUT_FILE_PATH = "C:\\Users\\navee\\Desktop\\MiniProject\\ocean_hazard_ml\\data\\youtube_comments.csv" 
    output_dir = os.path.dirname(OUTPUT_FILE_PATH)
    os.makedirs(output_dir, exist_ok=True)
    
    # Save the dataframe, ensuring 'text' is the very first column.
    combined_df.to_csv(OUTPUT_FILE_PATH, columns=['text', 'video_url', 'author', 'likes', 'time'], index=False)

    print("\n====================================")
    print(" FINAL DATASET CREATED SUCCESSFULLY ")
    print(" Total comments:", len(combined_df))
    print(f" Saved at: {OUTPUT_FILE_PATH}")
    print("====================================")

    print(combined_df.head())