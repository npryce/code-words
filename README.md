Code Words
==========

Get a handle on unfamiliar code by extracting and visualising the natural language programmers used when writing it.

Usage
-----

    <language>-code <source-file-or-directory>* | code-to-words <stop-word-file> | wordcloud -o <output-file>.png

E.g.

    python-code ~/myproject/*.py | code-to-words python-stop-words | wordcloud -o myproject.png


Languages supported:

 * Python: python-code, python-stop-words
 * Java: java-code, java-stop-words (just keywords) or cargo-cult-java-stop-words (also includes get, set, bean etc.)
 * C: c-code, c-stop-words
 * C++: c++-code, c++-stop-words


Examples
--------

Example visualisations of various open-source applications are in the examples/ directory.


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

