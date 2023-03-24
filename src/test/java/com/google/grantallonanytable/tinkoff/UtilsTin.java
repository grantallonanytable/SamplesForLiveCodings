package com.google.grantallonanytable.tinkoff;

// Задачки от тинькофа
import java.util.*;
public final class UtilsTin {
    private UtilsTin() {

    }

/*

Дан массив A длины N.
Окрестностью элемента массива называется максимальный подмассив, который содержит этот элемент, и при этом все элементы этого подмассива имеют одинаковую четность.
Для каждого элемента A вывести размер его окрестности
[2, 1, 3, 2] → [1, 2, 2, 1]
Окрестность - соседние слева и справа числа с той же чётностью.
У 1 в окрестности 3, значит размер окрестности 2.
У [1, 2, 3, 4] четность меняется на каждом элементе, все окрестности размером 1 → [1, 1, 1, 1].
У [2, 4, 6, 8, 9] у первых чисел окрестность размером 4 [4, 4, 4, 4, 1]
*/
        public static void task1 (String[] args) {
            System.out.println(solve1(Arrays.asList(1, 2, 3, 4, 1, 3, 5, 7, 8, 10, 12, 7, 9, 6)));
            System.out.println(solve1(Arrays.asList(1, 3, 5, 2, 4, 8, 10, 11)));
            System.out.println(solve1(Arrays.asList(1, 2, 3, 4, 5, 5)));
        }

        private static List<Integer> solve1(List<Integer> list) {
            List<Integer> res = new ArrayList<>();
            Integer cnt = 1;
            Integer odd = null;
            for(Integer index = 0; index < list.size(); index++) {
                Integer el = list.get(index);
                if ((odd != null) && (odd == el%2)) {
                    cnt++;
                }
                else {
                    for(Integer shift = 1; shift < cnt; shift++) {
                        res.set(index - shift - 1, cnt);
                    }
                    cnt = 1;
                    odd = el%2;
                }
                res.add(cnt);
            }

            for(Integer shift = 1; shift < cnt; shift++) {
                res.set(list.size() - shift -1, cnt);
            }
            return res;
        }

/*

Программист решил пойти в театр. Но он хочет сесть
как можно дальше от других людей, чтобы не заразиться covid.
Поэтому он хочет написать функцию, которая найдет
максимальное расстояние, на которое можно сесть от других зрителей в одном ряду.

Дан массив из 0 и 1 описывающий посадку зрителей в ряду.
0 - место свободно, 1 - место занято другим зрителем.
Вывести максимальное расстояние, на котором можно сесть от других зрителей.
Гарантируется, что есть 0 и 1.

Пример: [1, 0, 0, 0] расстояние 3 (включая место с программистом): [1, 0, 0, x]
Пример: [1,0,0,0,0,1] → расстояние 2: [1, 0, x, 0, 0, 1] - в этом случае за расстояние принимается минимальное расстояние до левого и правого соседа.

*/
        public static void task2 (String[] args) {
            System.out.println(solve2(Arrays.asList(1, 0, 0, 0, 1))); // 2
            System.out.println(solve2(Arrays.asList(1, 0, 0, 0, 0, 1))); // 2
            System.out.println(solve2(Arrays.asList(1, 0, 0, 0, 0, 0))); // 5
            System.out.println(solve2(Arrays.asList(0, 0, 0, 0, 0, 1))); // 5
            System.out.println(solve2(Arrays.asList(1, 0, 0, 0, 0, 0))); // 5
            System.out.println(solve2(Arrays.asList(0, 0, 0, 1, 0, 0))); // 3
            System.out.println(solve2(Arrays.asList(1, 0, 1, 0, 0, 1))); // 1
            System.out.println(solve2(Arrays.asList(1, 0, 1, 0, 0, 0, 1))); // 2
            System.out.println(solve2(Arrays.asList(1, 0, 0, 0, 1, 0, 0, 1))); // 2
            System.out.println(solve2(Arrays.asList(1, 1, 1, 1, 0))); // 1
            System.out.println(solve2(Arrays.asList(0, 1, 1, 1, 0))); // 1
        }

        private static int solve2(List<Integer> seats) {
            boolean was1 = false;
            int resultDist = 0;
            int dist = 0;
            for(Integer ind = 0; ind < seats.size(); ind ++) {
                boolean new1 = seats.get(ind) == 1;
                if (!new1) {
                    dist++;
                } else {
                    int userDist = was1 ? (dist + 1) / 2 : dist;
                    resultDist = resultDist < userDist ? userDist : resultDist;
                    was1 = true;
                    if (ind < seats.size() -1) { dist = 0; }
                }
            }
            if (seats.get(seats.size() - 1) == 0) {
                resultDist = resultDist < dist ? dist : resultDist;
            }
            return resultDist;
        }
}
