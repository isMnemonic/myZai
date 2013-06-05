#!/usr/bin/python
# -*- coding: utf-8 -*-

# import the necessary libs
import xbmc,xbmcgui
import subprocess,os

class TellstickPlayer(xbmc.Player) :
        def __init__ (self):
            xbmc.Player.__init__(self)

        def onPlayBackStarted(self):
            if xbmc.Player().isPlayingVideo():

        def onPlayBackEnded(self):
            if (VIDEO == 1):

        def onPlayBackStopped(self):
            if (VIDEO == 1):

        def onPlayBackPaused(self):
            if xbmc.Player().isPlayingVideo():

        def onPlayBackResumed(self):
            if xbmc.Player().isPlayingVideo():
player=TellstickPlayer()

VIDEO = 0

while(1):
    if xbmc.Player().isPlaying():
      if xbmc.Player().isPlayingVideo():
        VIDEO = 1

      else:
        VIDEO = 0

    xbmc.sleep(1000)

