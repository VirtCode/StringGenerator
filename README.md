# StringGenerator
## About
This Library is capable of generating random names out of the characterusage of a text.
The characterusage can be saved in .csv files and loaded later again.
With this Library you are able to write your own generation Algorithms quite easy.
## Version
The Current version is **1.1**
## License
This project is licensed under the MIT License.
Please consider reading the LICENSE file for more information.
## Usage
### Getting the JAR
To get the latest version of the library, download the latest release in the release section.
Or you can newly clone it from jitpack via:
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.VirtCode:StringGenerator:1.1'
}
```
### In Code
Learn a specific style from a textfile:
```java
Learner learner = new Learner();
learner.learnFromFile("[PathToFile1]");
learner.learnFromFile("[PathToFile2]");
Style style = learner.getStyle();
```
Save a learned style to a file:
```java
Loader loader = new Loader();
loader.saveStyle(style, "[PathToFile]");
```
Load a previously saved style from a file:
```java
Loader loader = new Loader();
Style style = loader.loadStyle("[PathToFile]");
```
Generate random String(s):
```java
//Choose from those Algorithms:
GenerationAlgorithm algorithm = new PairAlgorithm(); //Generates a String from Pairs
GenerationAlgorithm algorithm = new SwitchAlgorithm(); //Generates a String by switching between Vowels and Consonants

Generator generator = new Generator(style, algorithm);
generator.setLength([String length (Depends on algorithm)]);
generator.setFirst([First Character]);

String result = generator.generate();
String[] moreResults = generator.generate([Amount of Strings]);
```
