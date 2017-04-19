[![](https://jitpack.io/v/isacan/Andzu.svg)](https://jitpack.io/#isacan/Andzu)

# Andzu
In-App Android Debugging Tool With Enhanced Logging, Networking Info, Crash reporting And More.


https://camo.githubusercontent.com/d0e25b09a82bc4bfde9f1e048a092752eebbb4f3/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6c6963656e73652d4d49542d626c75652e7376673f7374796c653d666c6174

The debugger tool for Android developer. Display logs, network request,  while using the app. Easy accessible with its bubble head button :radio_button:. Easy to integrate in any apps, to handle development or testing apps easier. First version, there is plenty of room for improvement.

# Usage

- Extend your Application class from "AndzuApp"
- Extend your Activity from "AndzuActivity" and onCreate call initAndzu() method for show Bubble 
- For Network Request Log addInterceptor "AndzuInterceptor"
- For App Log user Logger log method.
- That's it
