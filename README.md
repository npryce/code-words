Code Words
==========

Get a handle on unfamiliar code by extracting and visualising the natural language programmers used when writing it.

![Board Game Example](https://raw.github.com/npryce/code-words/master/examples/multiplayer-board-game.png)

An example generated from a multiplayer boardgame written in Java.

Usage
-----

    <language>-code <source-file-or-directory>* | code-to-words -k <keyword-file> ... -s <stop-word-file> ... | wordcloud -o <output-file>.png

E.g.

    java-code project/src/ | code-to-words -k java-keywords -s cargo-cult-java-stop-words | wordcloud -o project.png


The stop-keyword files and stop-word files must have a single word per
line.

The words in keyword-files are filtered out after identifiers
have been extracted from the language but before any further processing.

The words in stop-word-files are filtered out after the identifiers
have been split into separate words at underscores or camel-case
boundaries and normalised to lowercase.

The wordcloud command has the following options:

 * -o _output-file_: output file name (image type is determined from the extension)
 * -s _width_<span/>x<span/>_height_ : width of the output image


Languages supported
-------------------

 * C: `c-code`
     * `c-keywords`: most C keywords
     * `c-primitive-type-keywords`: ignores basic C types (int, char, etc.)
 * C++: `c++-code`
     * `c++-keywords`: most C++ keywords
     * `c-primitive-type-keywords`: ignores basic C types (int, char, etc.)
 * Haskell: `haskell-code`
     * `haskell-keywords`
 * HTML: `html-text`
     * no stop words file provided. Stop words files for various natural languages can be found on the web.
 * Java: `java-code`.
     * `java-keywords`: most keywords
     * `java-primitive-type-keywords`: ignores primitive types
     * `cargo-cult-java-stop-words`: ignores get, set, bean etc.  Use with the -s flag.
 * JavaScript: `javascript-code`.
     * `javascript-keywords`: ignores keywords and reserved words (from ECMA-262 Edition 3)
     * `java-primitive-type-keywords`: ignores primitive types
     * `nodejs-globals-keywords`: ignores node.js globals
 * Python: `python-code`
     * `python-keywords`: most keywords
 * Ruby: `ruby-code`
     * `ruby-keywords`
 * Scala: `scala-code`
     * `scala-keywords`
 * PHP: `php-code`
     * `php-keywords`: shows some keywords that may be the result of poor programming practice.
     * `php-strict-keywords`: ignores all keywords

Examples
--------

Example visualisations of various applications are in the examples/ directory.


Dependencies
------------

To extract text from source code:

 * Bash
 * Gnu Sed
 * Grep
 * Awk

To extract text from HTML:

 * w3m

To visualise the results
 
 * Java 1.6

It should work on any desktop Linux. It does not yet work on MacOS unless you install the Gnu command-line tools.

To compile the Java wordcloud generator:

 * JDK 1.6
 * Gnu Make

