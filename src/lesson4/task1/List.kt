@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.angleInRadian
import lesson1.task1.discriminant
import lesson1.task1.sqr
import kotlin.math.sqrt
import kotlin.math.pow

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.lowercase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var answer = 0.0
    for (element in v) {
        answer += sqr(element)
    }
    return sqrt(answer)
}

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = if (list.isNotEmpty()) list.sum() / list.count() else 0.0

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val midValue = mean(list)
    for ((count, element) in list.withIndex()) {
        list[count] = element - midValue
    }
    return list
}

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int {
    var answer = 0
    for (i in 0 until a.count()) {
        answer += a[i] * b[i]
    }
    return answer
}

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int {
    var answer = if (p.isNotEmpty()) p[0] else 0
    for (i in 1 until p.count()) {
        answer += p[i] * x.toDouble().pow(i).toInt()
    }
    return answer
}

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> {
    var total = if (list.isNotEmpty()) list[0] else 0
    var lastTotal = total
    for (i in 1 until list.count()) {
        total += list[i]
        list[i] += lastTotal
        lastTotal = total
    }
    return list
}

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    val result = mutableListOf<Int>()
    var count = true
    var number = n
    var lastDiv = 2
    while (count) {
        count = false
        for (i in lastDiv..number) {
            if (number % i == 0) {
                result.add(i)
                count = true
                number /= i
                lastDiv = i
                break
            }
        }
    }
    return result
}

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    val answer = mutableListOf<Int>()
    var number = n
    while (number > base) {
        answer.add(number % base)
        number /= base
    }
    if (number == base) {
        answer.add(0)
        answer.add(1)
    } else answer.add(number)
    return answer.reversed()
}

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String {
    val list = convert(n, base)
    val answerString = StringBuilder()
    for (element in list) {
        if (element > 9) answerString.append((element + ('a'.code - 10)).toChar()) else answerString.append(element)
    }
    return answerString.toString()
}

/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var answer = 0
    var count = digits.count() - 1
    for (element in digits) {
        answer += element * base.toDouble().pow(count).toInt()
        count--
    }
    return answer
}

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int {
    val list = mutableListOf<String>()
    var codeLetter: Int
    val asciiLetterA = 'a'.code
    for (i in str) list.add(i.toString())
    for (i in 0 until list.count()) {
        codeLetter = list[i].toCharArray()[0].code + 10
        if ((codeLetter >= asciiLetterA)) list[i] = (codeLetter - asciiLetterA).toString()
    }
    return decimal(list.map { it.toInt() }, base)
}

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    val answer = StringBuilder()
    var number = n
    val glossary = mapOf(
        1000 to "M", 900 to "CM", 500 to "D", 400 to "CD", 100 to "C", 90 to "XC", 50 to "L",
        40 to "XL", 10 to "X", 9 to "IX", 5 to "V", 4 to "IV", 1 to "I"
    )
    for ((key, value) in glossary)
        if (number >= key) {
            answer.append(value.repeat(number / key))
            number -= key * (number / key)
        }
    return answer.toString()
}

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    val answer = StringBuilder()
    var number = n
    var count = false
    val thousand = if (n > 1000) n / 1000 else 0
    val glossary = mapOf(
        2000 to "две тысячи",
        1000 to "одна тысяча",
        900 to "девятьсот",
        800 to "восемьсот",
        700 to "семьсот",
        600 to "шестьсот",
        500 to "пятьсот",
        400 to "четыреста",
        300 to "триста",
        200 to "двести",
        100 to "сто",
        90 to "девяносто",
        80 to "восемьдесят",
        70 to "семьдесят",
        60 to "шестьдесят",
        50 to "пятьдесят",
        40 to "сорок",
        30 to "тридцать",
        20 to "двадцать",
        19 to "девятнадцать",
        18 to "восемнадцать",
        17 to "семнадцать",
        16 to "шестнадцать",
        15 to "пятнадцать",
        14 to "четырнадцать",
        13 to "тринадцать",
        12 to "двенадцать",
        11 to "одиннадцать",
        10 to "десять",
        9 to "девять",
        8 to "восемь",
        7 to "семь",
        6 to "шесть",
        5 to "пять",
        4 to "четыре",
        3 to "три",
        2 to "два", 1 to "один"
    )
    while (number > 0) {
        for ((key, value) in glossary) {
            if (number > 1000) {
                if (number >= key * 1000) {
                    if ((key != 1) && (key != 2) && (key != 11) && (key != 12)) answer.append(value)
                    else {
                        when (key) {
                            1 -> answer.append("одна тысяча")
                            2 -> answer.append("две тысячи")
                            11 -> answer.append("одиннадцать тысяч")
                            12 -> answer.append("двенадцать тысяч")
                        }
                        number %= (key * 1000)
                        if (number != 0) answer.append(" ")
                        break
                    }
                    number %= (key * 1000)
                    if (((key != 1) && (key != 2) && (key != 11) && (key != 12)) || number != 0) answer.append(" ")
                    count = true
                }
            }
            if (number < 1001) {
                if ((count == true) && ((n / 1000 % 10) != 1) && ((n / 1000 % 10) != 2)) {
                    answer.append(
                        when {
                            ((thousand % 100 > 4) && (thousand % 100 < 20)) ||
                                    (thousand % 10 == 0) || (thousand % 10 > 4) -> "тысяч"

                            else -> "тысячи"
                        }
                    )
                    answer.append(" ")
                    count = false
                    break
                }
                if (number >= key) {
                    answer.append(value)
                    number -= key * (number / key)
                    if (number != 0) answer.append(" ")
                }
            }
        }
    }
    if (answer[answer.length - 1] == ' ') answer.replace(answer.length - 1, answer.length, "")
    return answer.toString()
}