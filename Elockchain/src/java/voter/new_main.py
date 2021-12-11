#! /usr/bin/python

# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

__author__ = "A 04 Nishant Badlani"
__date__ = "$6 Dec, 2021 10:13:26 PM$"

import os
import sys
import cv2
import face_recognition
import datetime


i1=sys.argv[1]




def containsFace(filename):
    #     face_cascade=cv2.CascadeClassifier('assets/haarcascade_frontalface_default.xml')
    #     img=cv2.imread(filename,0)
    #     face_rect=face_cascade.detectMultiScale(img,scaleFactor=1.05,minNeighbors=5)
    image = face_recognition.load_image_file(filename)
    face_locations = face_recognition.face_locations(image)
    #print(face_locations)
    #print(len(face_locations))
    if(len(face_locations) == 1):
        return True
    else:
        return False

print(containsFace(i1));