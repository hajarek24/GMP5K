#include <stdio.h>
#include <ctype.h>

int main(int argc, char *argv[]) {
    if(argc != 3) {
        printf("Usage: %s <input> <output>\n", argv[0]);
        return 1;
    }

    FILE *in = fopen(argv[1], "r");
    FILE *out = fopen(argv[2], "w");
    if(!in || !out) return 1;

    int words = 0;
    int inWord = 0;  // 0 = pas dans un mot, 1 = dans un mot
    char c;
    while((c = fgetc(in)) != EOF) {
        if(isspace(c)) {
            inWord = 0;
        } else {
            if(inWord == 0) {
                words++;
                inWord = 1;
            }
        }
    }

    fprintf(out, "Word count: %d\n", words);

    fclose(in);
    fclose(out);
    return 0;
}
