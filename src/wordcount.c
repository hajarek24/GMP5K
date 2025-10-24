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
    char c, prev = ' ';
    while((c = fgetc(in)) != EOF) {
        if(isspace(c) && !isspace(prev)) words++;
        prev = c;
    }

    fprintf(out, "Word count: %d\n", words);

    fclose(in);
    fclose(out);
    return 0;
}
