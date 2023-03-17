# [Gold III] Algebra - 9139 

[문제 링크](https://www.acmicpc.net/problem/9139) 

### 성능 요약

메모리: 46956 KB, 시간: 3168 ms

### 분류

수학, 자료 구조, 세그먼트 트리, 순열 사이클 분할

### 문제 설명

<p>Malí matfyzáčci mají obvykle problém s algebraickými strukturami. Proto si budou ve školce procvičovat operace s permutacemi. Aby ale cvičení mělo smysl a matfyzáčci se něco naučili, byla zadefinována netradiční operace, tzv. <em>trojúhelníková operace</em>. Trojúhelníková operace má tři parametry <var>i</var>, <var>j</var> a <var>k</var>. <var>i</var> ≠ <var>j</var>, <var>j</var> ≠ <var>k</var>, <var>k</var> ≠ <var>i</var>. Při její aplikaci na permutaci se v permutaci číslo na pozici <var>i</var> přesune na pozici <var>j</var>, číslo na pozici <var>j</var> se přesune na pozici <var>k</var> a číslo na pozici <var>k</var>se přesune na pozici <var>i</var>. Úkolem malých matfyzáčků je zjistit, zda lze identickou permutaci pomocí trojúhelníkové operace převést na zadanou permutaci. Identická permutace je taková, která má na <var>i</var>-té pozici číslo <var>i</var>. Vy máte napsat program, který bude matfyzáčky kontrolovat.</p>

### 입력 

 <p>Vstup se skládá z několika bloků. Každý blok začíná řádkem s počtem prvků v permutaci <var>N</var>, 3 <img alt="<=" src="https://contest.felk.cvut.cz/01prg/solved/le.gif"> <var>N</var> <img alt="<=" src="https://contest.felk.cvut.cz/01prg/solved/le.gif"> 100 000. Vstup je ukončen řádkem obsahujícím nulu. Tento řádek nemáte dále zpracovávat. Na druhém řádku každého bloku je <var>N</var> vesměs různých celých čísel z intervalu 1 až <var>N</var>, která popisují cílovou permutaci.</p>

### 출력 

 <p>Na výstup má váš program pro každý blok vypsat jeden řádek obsahující text "<code>Permutaci lze prevest.</code>", pokud zadanou permutaci lze získat z identické permutace pomocí posloupnosti trojúhelníkových operací. Pokud permutaci získat nelze, má řádek obsahovat text "<code>Matfyzacci maji smulu.</code>".</p>

