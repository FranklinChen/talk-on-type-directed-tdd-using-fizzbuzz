# Use Beamer for slides, Minted for code highlighting.
# Minted requires Pygments: http://pygments.org/ 

all:	handout.pdf presentation.pdf

handout.pdf:	slides.tex

presentation.pdf:	slides.tex

%.pdf:	%.tex
	latexmk -pdf -shell-escape $*.tex

.PHONY:	all
