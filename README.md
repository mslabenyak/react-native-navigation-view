
# react-native-navigation-view

## Getting started

`$ npm install react-native-navigation-view --save`

### Mostly automatic installation

`$ react-native link react-native-navigation-view`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-navigation-view` and add `RNNavigationView.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNNavigationView.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNNavigationViewPackage;` to the imports at the top of the file
  - Add `new RNNavigationViewPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-navigation-view'
  	project(':react-native-navigation-view').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-navigation-view/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-navigation-view')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNNavigationView.sln` in `node_modules/react-native-navigation-view/windows/RNNavigationView.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Navigation.View.RNNavigationView;` to the usings at the top of the file
  - Add `new RNNavigationViewPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNNavigationView from 'react-native-navigation-view';

// TODO: What to do with the module?
RNNavigationView;
```
  