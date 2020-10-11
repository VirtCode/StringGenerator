# StringGenerator
## About
This library is capable of generating random strings. For the generation process, it uses occurances and other data about characters which it has extracted from Words or Texts.
This data can be created, saved and loaded by this library. Additionally, you can choose between different Generators to generate your strings, each using other principles. You can also write new Generator by yourself, using that extracted Data.
This library does not use any machine learning techniques, so it can be run without a huge performance impact.
## Features
* Learning styles from Strings
* Saving and Loading Styles to String
* Different Generation Algorithms
  * Single Generator
  * Pair Generator
  * Switch Generator 
* Seeded Generation
* Different Attributes depending on Generator
### Generators
There currently exist 3 default Generators
#### Single Generator
This generator generates strings just by using random characters with no relation to each other. Because of that you can set various parameters like length, beginning and ending letters <br>
Resulting strings can be difficult to spell and do not appear as possible words.
#### Pair Generator
This generator generates strings by using pairs that occured in the original text. It does so by appending a character that occurs in a pair with the character before. You can also set parameters like length and beginning letter.<br>
Resulting strings (mostly) appear as custom words and are spellable. The string is also very customizable.
#### Switch Generator
This generator generates strings using vowels and consonant combinations. It does so by alternatingly appending vowel and consonant combination onto each other. Because of that you can only set the length in combinations and only set whether the string should start with a vowel or not.<br>
Resulting strings should be spellable and appear as words. But there is a tradeoff in customizability of the string.
## Usage
### Version
The current version is **2.0**
### Getting the Library
To get the latest version of the library, you could add the dependency to your build.gradle file via [JitPack](https://jitpack.io/#VirtCode/StringGenerator/ "StringGenerator on JitPack"). (Visit [JitPack](https://jitpack.io/#VirtCode/StringGenerator/ "StringGenerator on JitPack") for other Dependency Managers)
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    compile 'com.github.VirtCode:StringGenerator:[Version]'
}
```
Or you could download a built Jar in the release section.
### In Code
Learn a specific Style from a string and convert it into a json string.
```java
Learner learner = new Learner("[name-of-style]", "[description-of-style]", "[source-of-style]");
learner.learn([string-to-learn-from]);
Style style = learner.get();
```
Convert to and from Json (more formats could come soon).
```java
String stlyeInJson = StyleStorage.toJSON(style);
Style style = StyleStorage.fromJSON(styleInJson);
```
Generate string using a Generator (Example here with Pair Algorithm).
```java
PairGenerator generator = new PairGenerator(style);

//Options for every Generator (Optional)
generator.setWeighted([whether-to-use-weighted]); // Use weighted random distribution (Ones used more often are more common)
generator.setSeed([your-seed]);                   // Seed for the Generation
//Generatorspecific Options (Optional)
generator.setLength([your-length]);
generator.setBeginningLetter([your-beginning-letter]);

String s = generator.generate();
```
You can also have a look at the javadoc if you want to have more indepth information about the library or especially about the options for other generators.
## License
This Library is licensed under the MIT License. If you want more information about that, have a look at the LICENSE file.
