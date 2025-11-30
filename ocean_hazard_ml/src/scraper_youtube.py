import yt_dlp
import pandas as pd

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
            print("Error scraping:", e)
            return pd.DataFrame()

    if "comments" not in info:
        print("No comments found for:", video_url)
        return pd.DataFrame()

    comments = []
    count = 0

    for c in info["comments"]:
        if count >= limit:
            break

        comments.append({
            "video_url": video_url,
            "author": c.get("author", ""),
            "text": c.get("text", ""),
            "likes": c.get("like_count", 0),
            "time": c.get("time_text", "")
        })

        count += 1

    print(f"✔ Extracted {len(comments)} comments")
    return pd.DataFrame(comments)

if __name__ == "__main__":

    # Sample videos
    video_links = [
        "https://www.youtube.com/watch?v=MUC5kNCMetY",
        "https://www.youtube.com/watch?v=kLmopK-qDwk",
        "https://www.youtube.com/watch?v=Cys8581RSXE",
        "https://www.youtube.com/watch?v=UZecnRSnOdg"
    ]

    all_comments = []

    for url in video_links:
        df = get_comments(url, limit=600)
        all_comments.append(df)

    # Combine all dataframes
    combined_df = pd.concat(all_comments, ignore_index=True)

    # Remove duplicates
    combined_df.drop_duplicates(subset=["text"], inplace=True)

    # Save final CSV
    combined_df.to_csv("data/youtube_comments.csv", index=False)

    print("\n====================================")
    print(" FINAL DATASET CREATED SUCCESSFULLY ")
    print(" Total comments:", len(combined_df))
    print(" Saved at: data/youtube_comments.csv")
    print("====================================")

    print(combined_df.head())
