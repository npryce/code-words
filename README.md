Code Words
==========

Get a handle on unfamiliar code by extracting and visualising the natural language programmers used when writing it.

Usage
-----

    <language>-code <source-file-or-directory>* | code-to-words <stop-word-file> [<stop-word-file>...] | wordcloud -o <output-file>.png

E.g.

    java-code project/src/ | code-to-words java-stop-words cargo-cult-java-stop-words | wordcloud -o project.png


Languages supported:

 * Python: `python-code`.
     * python-stop-words
 * Java: `java-code`.
     * `java-stop-words`: most keywords
     * `java-primitive-type-stop-words`: ignores primitive types
     * `cargo-cult-java-stop-words`: ignores get, set, bean etc.
 * C: `c-code`
     * `c-stop-words`: most C keywords
     * `c-primitive-type-stop-words`: ignores basic C types (int, char, etc.)
 * C++: `c++-code`
     * `c++-stop-words`: most C++ keywords
     * `c-primitive-type-stop-words`: ignores basic C types (int, char, etc.)


Examples
--------

Example visualisations of various applications are in the examples/ directory.


Dependencies
------------

To extract text from source code:

 * Bash
 * Sed
 * Awk

(Should work on any desktop Linux / Unix OS).

To visualise extracted text as word clouds:

 * JDK 1.6

(No command-line build yet, but the wordcram-cli directory contains project files for the free IntelliJ Community Edition).

