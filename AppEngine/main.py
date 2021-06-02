import numpy as np
import tensorflow as tf
import tensorflow_hub as hub
from tqdm import tqdm
from werkzeug.utils import secure_filename
import urllib.request

from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.preprocessing import image


# Flask utils
from flask import Flask, redirect, url_for, request, render_template, jsonify, flash

# Define a flask app
app = Flask(__name__)

# Load your trained model
model = tf.keras.models.load_model('food20class87acc.h5',custom_objects={'KerasLayer':hub.KerasLayer})
model.make_predict_function()          # Necessary

def model_predict(img_path, model):
    img = image.load_img(img_path, target_size=(224, 224))

    # Preprocessing the image
    x = image.img_to_array(img)
    x = np.expand_dims(x, axis=0)
    images = np.vstack([x])/ 255.0

    preds = model.predict(images)
    if preds[0] > 0.5:
      return "......"
    else:
      return "------"

@app.route('/')
def index():
  return """
          Application is working
  """

@app.route('/predict', methods=['POST'])
def upload_image():
  if request.method == 'POST':
    f = request.files['file']
    file_path = secure_filename(f.filename)
    f.save(file_path)

    #make prediction
    preds = model_predict(file_path, model)
    return preds


if __name__ == '__main__':
    # app.debug = True
    app.run(debug=True)