# =======================================================
# ML/api.py
# -------------------------------------------------------
# Exposes the prediction pipeline as a RESTful API.
# Spring Boot will send a list of new comments here.
# =======================================================
from flask import Flask, request, jsonify
from pipeline import predict_batch # Import the core prediction function
import logging

# Configure basic logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

app = Flask(__name__)

# The endpoint Spring Boot will call (e.g., POST to http://localhost:5000/analyze)
@app.route('/analyze', methods=['POST'])
def analyze():
    """
    Accepts a JSON list of texts and returns the classified results.
    Expected JSON body: {"texts": ["comment 1", "comment 2", ...]}
    """
    
    # 1. Input Validation and Parsing
    try:
        data = request.get_json()
        if not data or 'texts' not in data:
            logging.error("Received request with missing 'texts' key or empty body.")
            return jsonify({"error": "Invalid input format. Expected {'texts': [...]}."}), 400

        text_list = data['texts']
        if not isinstance(text_list, list) or not all(isinstance(i, str) for i in text_list):
            logging.error("'texts' element is not a list of strings.")
            return jsonify({"error": "'texts' must be a list of strings."}), 400

        if not text_list:
            return jsonify({"message": "Received empty list, returning empty results."}), 200

        logging.info(f"Received {len(text_list)} comments for batch analysis.")

    except Exception as e:
        logging.error(f"Error parsing request JSON: {e}", exc_info=True)
        return jsonify({"error": "Error processing request body."}), 400

    # 2. Pipeline Execution
    try:
        # Call the prediction function from pipeline.py
        results = predict_batch(text_list)
        
        logging.info(f"Successfully analyzed and classified {len(results)} comments.")
        
        # 3. Return results as JSON
        return jsonify(results), 200

    except Exception as e:
        # Log the internal error for debugging and return a generic server error
        logging.error(f"Critical error during ML pipeline execution: {e}", exc_info=True)
        return jsonify({"error": "Internal server error during analysis. Check ML server logs."}), 500

if __name__ == '__main__':
    logging.info("Starting ML Prediction API Server...")
    # The 'host' parameter makes the server accessible from outside the local machine (if needed)
    # The 'port' is the one the Spring Boot application will call.
    app.run(host='0.0.0.0', port=5000)