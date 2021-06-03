import numpy as np
import tensorflow as tf
import tensorflow_hub as hub
from tqdm import tqdm
from werkzeug.utils import secure_filename
import urllib.request
import cv2
import matplotlib.pyplot as plt

from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.preprocessing import image


# Flask utils
from flask import Flask, redirect, url_for, request, render_template, jsonify, flash

# Define a flask app
app = Flask(__name__)

# Load your trained model
model = load_model('model3class_work.h5')
#model.make_predict_function()          # Necessary


def model_predict(img_path, model):
    img = image.load_img(img_path, target_size=(100, 100))

    # Preprocessing the image
    x = image.img_to_array(img)
    x = np.expand_dims(x, axis=0)
    images = np.vstack([x])

    preds = model.predict(images)[0]
    #print(pred)

    predic = np.argmax(pred)
    #print(predic)
	
    label = ['chicken_wings', 'ice_cream', 'spaghetti']
    
	predic_food = label[predic]
	
	return predic_food

#img = fn
#img = cv2.imread(img) # reads image
#plt.imshow(img)
#print('Image = ' + label[predic])
    

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