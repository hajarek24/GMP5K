---

```markdown
# Projet Makefile Séquentiel et Word Count

## Structure du projet

```

makeproject/
├── src/
│   ├── MakefileParser.java
│   ├── TaskGraph.java
│   ├── SequentialExecutor.java
│   └── wordcount.c
├── bin/               # Contient les fichiers .class compilés
├── wordcount          # Binaire compilé du programme C
├── input.txt          # Fichier d'entrée pour le word count
├── result.txt         # Fichier de sortie généré par wordcount
└── Makefile           # Makefile séquentiel à exécuter

````

---

## Tests du Makefile séquentiel

### 1️⃣ Compilation

#### Java

```bash
# Compiler tous les fichiers Java et placer les .class dans bin/
javac -d bin src/*.java
````

**Remarque :**
Un warning apparaît pour `TaskGraph.java` concernant l’utilisation d’API dépréciée, mais cela n’empêche pas l’exécution.

#### C

```bash
# Compiler le programme C wordcount
gcc src/wordcount.c -o wordcount
# Rendre le binaire exécutable
chmod +x wordcount
```

---

### 2️⃣ Exécution du make séquentiel

```bash
# Lancer le make séquentiel en Java
java -cp bin SequentialExecutor Makefile
```

* Le programme exécute les commandes du Makefile dans l’ordre séquentiel :

  1. Supprime `result.txt` si existant
  2. Exécute `./wordcount input.txt result.txt`

---

### 3️⃣ Vérification du résultat

```bash
cat result.txt
```

**Résultat attendu :**

```
Word count: 10
```

* Le nombre de mots correspond bien au contenu de `input.txt`
* Le test confirme que le **make séquentiel fonctionne correctement**.

---

### 4️⃣ Notes sur le processus

* Initialement, il y avait un problème d’exécution avec `Runtime.exec()` car `result.txt` n’était pas créé.
* Après avoir rendu `wordcount` exécutable (`chmod +x`) et utilisé le binaire correct dans le Makefile, tout fonctionne.
* Les commandes Java sont exécutées depuis le répertoire racine avec `-cp bin` pour indiquer le chemin des `.class`.

```

---

```
