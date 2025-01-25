from flask import Flask, request, jsonify
import torch

# Modeli yükleyin
model = torch.jit.load("model.pt")
model.eval()

app = Flask(__name__)

@app.route("/predict", methods=["POST"])
def predict():
    data = request.json["data"]  # JSON içindeki girdiyi alın
    tensor = torch.tensor(data)  # Veriyi tensöre dönüştürün
    output = model(tensor)       # Model tahminini yapın
    return jsonify(output.tolist())  # Sonuçları JSON olarak döndürün

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)