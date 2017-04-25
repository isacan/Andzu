[![](https://jitpack.io/v/isacan/Andzu.svg)](https://jitpack.io/#isacan/Andzu)

![](https://camo.githubusercontent.com/d0e25b09a82bc4bfde9f1e048a092752eebbb4f3/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6c6963656e73652d4d49542d626c75652e7376673f7374796c653d666c6174)

![](https://img.shields.io/badge/Android%20Arsenal-Andzu-orange.svg?style=flat)

# Andzu
In-App Android Debugging Tool With Enhanced Logging, Networking Info, Crash reporting And More.

The debugger tool for Android developer. Display logs, network request,  while using the app. Easy accessible with its bubble head button :radio_button:. Easy to integrate in any apps, to handle development or testing apps easier. First version, there is plenty of room for improvement.

<p align="center">
 <img src="https://media.giphy.com/media/PbGjfYclH0hry/giphy.gif">
</p>

# Usage

- Extend your Application class from "AndzuApp"
    ```java
    public class App extends AndzuApp {
        @Override
        public void onCreate() {
            super.onCreate();
        }
    }
    ```
- Extend your Activity from "AndzuActivity" and onCreate call initAndzu() method for show Bubble
    ```java
    public class MainActivity extends AndzuActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initAndzu();
        }
    }
    ```
- For Network Request Log addInterceptor "AndzuInterceptor"
    ```java
    LoggingInterceptor interceptor = new LoggingInterceptor();

    OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();
    ```
- For App Log user Logger log method.
    ```java
    Logger.inf("info");

    Logger.err("error",Logger.HI_PRI);

    Logger.d("debug");

    Logger.v("verbose",Logger.LOW_PRI);

    Logger.w("warn");
    ```
- That's it

# Installation

Download the latest JAR or grab via Maven:
  ```java
  <repositories>
      <repository>
          <id>jitpack.io</id>
          <url>https://jitpack.io</url>
      </repository>
    </repositories>
    
    <dependency>
	    <groupId>com.github.isacan</groupId>
	    <artifactId>Andzu</artifactId>
	    <version>0.28</version>
	</dependency>
  ```  
or Gradle:
Add it in your root build.gradle at the end of repositories:
  ```java
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  Add the dependency
  ```java
  dependencies {
	        compile 'com.github.isacan:Andzu:0.28'
	}
  ```
 
# Contact
 - İsa Can Akkoca
 - Twitter [@isa_can](https://twitter.com/isa_can)
 - LinkedIn https://www.linkedin.com/in/isa-can-akkoca-37650b2a/
 
 
# Inspiration 
https://github.com/remirobert/Dotzu
 
# License
Andzu is released under the [MIT License.](https://opensource.org/licenses/MIT)

 
