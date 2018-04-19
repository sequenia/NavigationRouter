# Navigation Router
[![Release](https://jitpack.io/v/foxaice/NavigationRouter.svg)](https://jitpack.io/#foxaice/NavigationRouter)

```Navigation Router``` was created for easy life with android fragments

## Integration
>Step 1. Add the JitPack repository to your build file
```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
>Step 2. Add the dependency
```groovy
	dependencies {
	        compile 'com.github.foxaice:NavigationRouter:v0.1-alpha'
	}
```
## How to Use
### Initialization
>```Navigation Router``` is initialized by **constructor**
```java
 public NavigationRouter(AppCompatActivity activity, int containerId)
```
If ```activity``` implements [```OnChangeScreenListener```] then the method  [```onScreenChanged(@Nullable Fragment fragment)```] will return the current fragment for any change in the state of the screens stack

```containerId``` - the container of the screens ([```FrameLayout```])

### Addable fragments
>To add a fragment to the top of the other, add marker-interface [```Addable```] for this fragment
And when you open the screen by
```java
NavigationRouter.openScreen(Fragment);
```
>```NavigationRouter``` uses within itself:
```java
 FragmentManager.beginTransaction().add(containerId,fragment,fragmentTag).commit();
```

### Replaceable fragments
>To add a fragment to replace all the content in the container, add marker-interface [```Replaceable```] for this fragment
And when you open the screen by
```java
NavigationRouter.openScreen(Fragment);
```
>```NavigationRouter``` uses within itself:
```java
 FragmentManager.beginTransaction().replace(containerId,fragment,fragmentTag).commit();
```

### Opening of Screens
>Opens the screen by fragment and added that fragment to the stack
```java
public void openScreen(Fragment fragment)
```
```fragment``` - the screen that you want to open

### Closing of Current Screen
>Removes current screen from the stack of screens
```java
public void closeCurrentScreen()
```

### Closing of Screens to a Specific Screen
>Removes all screens until the screen by the position inclusive or exclusive from the stack of screens
```java
public void closeToScreen(int position, boolean includePosition)
```
```position``` - the position of the screen
```includePosition``` - if **true** ```Navigation Router```removes all screens include the screen by the position, otherwise removes without it

### Closing of All Screens
>Removes all screen inclusive from the stack of screens
```java
 public void closeAllScreens()
```

### Getting the Current Screen
>Returns the current fragment of the fragments container
```java
public Fragment getCurrentScreen()
```

### Getting the Screen Quantity
>Returns current quantity of screens
```java
public int getScreenCount()
```

[//]: # ()

   [```Addable```]:<https://github.com/foxaice/NavigationRouter/blob/v0.1-alpha/navigation-router/src/main/java/com/sequenia/navigation_router/NavigationRouter.java#L17-L23>
   [```Replaceable```]:<https://github.com/foxaice/NavigationRouter/blob/v0.1-alpha/navigation-router/src/main/java/com/sequenia/navigation_router/NavigationRouter.java#L25-L31>
   [```NavigationRouterActivity```]:<https://github.com/foxaice/NavigationRouter/blob/v0.1-alpha/navigation-router/src/main/java/com/sequenia/navigation_router/NavigationRouterActivity.java>
   [```OnChangeScreenListener```]:<https://github.com/foxaice/NavigationRouter/blob/v0.1-alpha/navigation-router/src/main/java/com/sequenia/navigation_router/OnChangeScreenListener.java>
   [```onScreenChanged(@Nullable Fragment fragment)```]:<https://github.com/foxaice/NavigationRouter/blob/4b431287834f2e40a31c85fcdcc5997e29bddbfd/navigation-router/src/main/java/com/sequenia/navigation_router/OnChangeScreenListener.java#L10-L15>
   [```FrameLayout```]:<https://developer.android.com/reference/android/widget/FrameLayout.html>