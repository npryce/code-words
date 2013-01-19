
SRCDIR=wordcram-cli/src/
OUTDIR=wordcram-cli/out/make

SRCS:=$(shell find $(SRCDIR) -name '*.java')
JAR=wordcram-cli/lib/wordcram-cli.jar
LIBS:=$(wildcard wordcram-cli/lib/*/*.jar)

pathify = $(subst $(eval) ,:,$1)

.PHONY: all
all: $(JAR)

$(JAR): $(SRCS) $(LIBS) $(OUTDIR)/manifest.mf
	@mkdir -p $(OUTDIR)/classes
	javac -source 1.6 -cp $(call pathify,$(LIBS)) -d $(OUTDIR)/classes $(SRCS)
	jar cfme $@ $(OUTDIR)/manifest.mf com.natpryce.wordcloud.CLI -C $(OUTDIR)/classes .


$(OUTDIR)/manifest.mf: $(LIBS)
	@mkdir -p $(dir $@)
	echo "Class-Path: $(LIBS:wordcram-cli/lib/%=%)" > $@

.PHONY: clean
clean:
	rm -rf $(OUTDIR) $(JAR)

.PHONY:
again: clean all
