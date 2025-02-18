@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson6.task1

import lesson1.task1.angleInRadian
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.lang.StringBuilder
import kotlin.math.max

// Урок 6: разбор строк, исключения
// Максимальное количество баллов = 13
// Рекомендуемое количество баллов = 11
// Вместе с предыдущими уроками (пять лучших, 2-6) = 40/54

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main() {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        } else {
            println("Прошло секунд с начала суток: $seconds")
        }
    } else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}


/**
 * Средняя (4 балла)
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку.
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30.02.2009) считается неверными
 * входными данными.
 */
fun dateStrToDigit(str: String): String = TODO()

/**
 * Средняя (4 балла)
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30 февраля 2009) считается неверными
 * входными данными.
 */
fun dateDigitToStr(digital: String): String = TODO()

/**
 * Средняя (4 балла)
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -89 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку.
 *
 * PS: Дополнительные примеры работы функции можно посмотреть в соответствующих тестах.
 */
fun flattenPhoneNumber(phone: String): String = TODO()

/**
 * Средняя (5 баллов)
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int = TODO()

/**
 * Сложная (6 баллов)
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки, а также в случае отсутствия удачных попыток,
 * вернуть -1.
 */
fun bestHighJump(jumps: String): Int = TODO()

/**
 * Сложная (6 баллов)
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
fun plusMinus(expression: String): Int = TODO()

/**
 * Сложная (6 баллов)
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int = TODO()

/**
 * Сложная (6 баллов)
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть больше нуля либо равны нулю.
 */
fun mostExpensive(description: String): String {
    val pattern = Regex("""( *.+ (\d*\.\d*|\d*);?)+""")
    var pairOfProduct: Pair<String, Double>
    val listOfProdutcs: List<String>
    var maxPrice = -1.0
    var expensiveProduct = ""
    if (pattern.matches(description)) {
        if (";" in description) {
            listOfProdutcs = description.split("; ").toMutableList()
            for (stringProduct in listOfProdutcs) {
                pairOfProduct = stringProduct.split(" ")[0] to stringProduct.split(" ")[1].toDouble()
                if (pairOfProduct.second > maxPrice) {
                    maxPrice = pairOfProduct.second
                    expensiveProduct = pairOfProduct.first
                }
            }
        } else return description.split(" ")[0]
    }
    return expensiveProduct
}


/**
 * Сложная (6 баллов)
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 *
 * Вернуть -1, если roman не является корректным римским числом
 */
fun fromRoman(roman: String): Int {
    val glossary = mapOf(
        "M" to 1000,
        "CM" to 900,
        "D" to 500,
        "CD" to 400,
        "C" to 100,
        "XC" to 90,
        "L" to 50,
        "XL" to 40,
        "X" to 10,
        "IX" to 9,
        "V" to 5,
        "IV" to 4,
        "I" to 1
    )
    val pattern = Regex("""(M)*((CM)*|(D)(C)*|(CD)|)*(C)*((XC)|(L)(X)*|(XL)(X)*)*(X)*((IX)|(V)*(I)*|(IV)|(I)*)""")
//  Регекс проверяет всевозможные соединения римских цифр и возможность их отсутсвия
    var answer = 0
    var condition: Boolean
    var timeString: String
    var newNumber = 0
    if ((!pattern.matches(roman)) || (roman == "")) return -1
    for (number in 0 until roman.count()) {
        if (!glossary.containsKey(roman[newNumber].toString())) return -1
        condition = true
        if (glossary.containsKey(roman[newNumber].toString())) {
            timeString = roman[newNumber].toString()
            if (newNumber + 1 < roman.count()) {
                if (glossary.containsKey(timeString + roman[newNumber + 1])) {
                    timeString += roman[newNumber + 1]
                    answer += glossary[timeString]!!.toInt()
                    condition = false
                    newNumber++
                }
            }
            if (condition) {
                answer += glossary[timeString]!!.toInt()
            }
        }
        newNumber++
        if (newNumber == roman.count()) break
    }
    return answer
}

/**
 * Очень сложная (7 баллов)
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным сим волом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> = TODO()

//Тест
//fun gasStation(carPetrol: Map<String, String>, gasStations: String): Map<String, String> {
//    var answer = mutableMapOf<String, String>()
//    var bestChoice = mutableMapOf<String, String>()
//    var prices = mutableMapOf<String, String>()
//    var currentName: String
//    var nextName = ""
//    var trueGas: String
//    var truevalue: String
//    var keyAndValue: List<String>
//    var allGas: List<String>
//    val listGasStations: List<String>
//    if (Regex("""([а-яА-Яa-zA-Z]+:( [а-яА-Я]+(\s\d+\s|\s)- (\d+\.\d+|\d+);)+)+""").matches(gasStations)) {
//        listGasStations = gasStations.split(':')
//        currentName = listGasStations[0]
//        for (stringGasStation in listGasStations) {
//            if (';' in stringGasStation) nextName =
//                stringGasStation.replace("( [а-яА-Я]+(\\s\\d+\\s|\\s)- (\\d+\\.\\d+|\\d+);)".toRegex(), "")
//            trueGas = stringGasStation.replace("\\s".toRegex(), "")
//            allGas = trueGas.split(';')
//            for (strGas in allGas) {
//                keyAndValue = strGas.split('-')
//                if (keyAndValue.size > 1) {
//                    if (!prices.keys.contains(keyAndValue[0])) {
//                        prices[keyAndValue[0]] = keyAndValue[1]
//                        if (!bestChoice.keys.contains(keyAndValue[0])) {
//                            bestChoice[keyAndValue[0]] = currentName
//                        }
//                    } else {
//                        if (prices[keyAndValue[0]]?.toDouble()!! > keyAndValue[1].toDouble()) {
//                            prices[keyAndValue[0]] = keyAndValue[1]
//                            bestChoice[keyAndValue[0]] = currentName
//                        }
//                    }
//                }
//            }
//            if (stringGasStation.contains(';')) currentName = nextName
//        }
//    } else throw IllegalArgumentException()
//
//    println(prices)
//    println(bestChoice)
//    println(carPetrol)
//    for ((key, value) in carPetrol) {
//        truevalue = value.replace("\\s".toRegex(), "")
//        println(truevalue)
//        println(bestChoice.keys)
//        if (value in bestChoice.keys) answer[key] = "gag"
//        else throw IllegalStateException()
//    }
//    return answer
//}


//fun taxCounter(taxes: String, money: Int): Int {
//    var answerTax = 0
//    var stringTax: MutableList<String>
//    var textTaxes: List<String>
//    val taxesMap = mutableMapOf<String, Int>()
//    if (Regex("""(\d+ y\.e\. - \d+%; )+else - \d+%""").matches(taxes)) {
//        textTaxes = taxes.split(';')
//        for (tax in textTaxes) {
//            println(tax)
//            stringTax = tax.split(" ") as MutableList<String>
//            println(stringTax)
//            if (stringTax[0] == "") stringTax.removeAt(0)
//            println(stringTax[0])
//            taxesMap[(stringTax[0].replace("\\s".toRegex(), ""))] =
//                (stringTax[3].replace("\\s|%".toRegex(), "")).toInt()
//            println(taxesMap)
//        }
//    } else throw IllegalArgumentException()
//    return answerTax
//}

fun placesNames(
    places: MutableList<MutableList<Boolean>>,
    reqest: Map<String, Pair<Int, Int>>
): Map<String, MutableList<Int>> {
    val answer = mutableMapOf<String, MutableList<Int>>()
    val truePlaces = places
    var countNeedSeat: Int
    var countOfEmptySeats: Int
    for ((name, place) in reqest) {
        countOfEmptySeats = 0
        countNeedSeat = 0
        if ((place.second < 0) || (place.first < 0) || (place.first > (places.count() - 1))) throw IllegalStateException()
        for (i in places[place.first]) {
            if (i) {
                countOfEmptySeats++
            }
        }
        if (countOfEmptySeats < place.second) throw IllegalStateException()
        println(truePlaces)
        for (i in 0 until truePlaces[place.first].count()) {
            if (place.second == countNeedSeat) break
            if (!truePlaces[place.first][i]) {
                countNeedSeat++
                truePlaces[place.first][i] = true
                if (!answer.keys.contains(name)) answer[name] = mutableListOf(i)
                else answer[name] = (answer[name]!! + i) as MutableList<Int>
            }
        }
        if (place.second == 0) answer[name] = mutableListOf()
        println(truePlaces)
        println(answer)
    }
    return answer
}