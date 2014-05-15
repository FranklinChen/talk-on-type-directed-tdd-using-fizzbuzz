# Use Beamer for slides, Minted for code highlighting.
# Minted requires Pygments: http://pygments.org/ 
PDFLATEX = pdflatex

all:	handout.pdf presentation.pdf

handout.pdf:	slides.tex

presentation.pdf:	slides.tex

%.pdf:	%.tex
	$(PDFLATEX) -shell-escape $^

.PHONY:	all
