Code Words
==========

Get a handle on unfamiliar code by extracting and visualising the natural language programmers used when writing it.

![Board Game Example](https://raw.github.com/npryce/code-words/master/examples/multiplayer-board-game.png)


Usage
-----

    <language>-code <source-file-or-directory>* | code-to-words <stop-word-file> [<stop-word-file>...] | wordcloud -o <output-file>.png

E.g.

    java-code project/src/ | code-to-words java-stop-words cargo-cult-java-stop-words | wordcloud -o project.png


Languages supported:

 * C: `c-code`
     * `c-stop-words`: most C keywords
     * `c-primitive-type-stop-words`: ignores basic C types (int, char, etc.)
 * C++: `c++-code`
     * `c++-stop-words`: most C++ keywords
     * `c-primitive-type-stop-words`: ignores basic C types (int, char, etc.)
 * Java: `java-code`.
     * `java-stop-words`: most keywords
     * `java-primitive-type-stop-words`: ignores primitive types
     * `cargo-cult-java-stop-words`: ignores get, set, bean etc.
 * Python: `python-code`
     * `python-stop-words`: most keywords
 * Ruby: `ruby-code`
     * `ruby-stop-words`


Examples
--------

Example visualisations of various applications are in the examples/ directory.


Dependencies
------------

To extract text from source code:

 * Bash
 * Gnu Sed
 * Awk
 * Java 1.6

Should work on any desktop Linux. Does not work on MacOS unless you install the Gnu command-line tools.

To compile the Java wordcloud generator:

 * JDK 1.6
 * Gnu Make

