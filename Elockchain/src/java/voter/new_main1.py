#! /usr/bin/python

# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

__author__ = "A 04 Nishant Badlani"
__date__ = "$6 Dec, 2021 11:04:11 PM$"

import os
import sys
import cv2
import face_recognition
import datetime


i1=sys.argv[1]
i2=sys.argv[2]
print("Hello");
image1 = face_recognition.load_image_file(i1)
image2 = face_recognition.load_image_file(i2)
known_faces = []
face_encoding1 = face_recognition.face_encodings(image1)[0]
known_faces.append(face_encoding1)
face_encoding2 = face_recognition.face_encodings(image2)[0]
TOLERANCE = 0.475
results = face_recognition.compare_faces(known_faces, face_encoding2, TOLERANCE)
print("Result: ",results)
