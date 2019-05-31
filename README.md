# StringGenerator
## About
You have ever wanted to generate your own really random names in your software?
Then this is the right Library for you.
This Library is capable of generating random names out of the characterusage of a text.
## Version
The Current version is **1.0**
## License
This project is licensed under the MIT License.
Please consider reading the LICENSE file for more information.
## Usage
### Getting the JAR
To get the latest version of the library, download the latest jar in the builds folder.
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