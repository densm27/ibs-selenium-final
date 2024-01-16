#language: ru

@all
Функционал: Поиск Regard

  @firstTest
  Сценарий: Поиск видеокарт
    * Выбрать категорию "Комплектующие для ПК" в главном меню
    * Выбрать подкатегорию "Видеокарты" в списке
    * Выбрать производителя "Gigabyte"
    * Задать минимальную цену "20000" рублей
    * Проверить, что на странице отображается не более "24" товаров
    * Запомнить наименование первого товара в списке
    * Выполнить поиск по сохраненному названию товара
    * Проверить, что на странице отображается не более "1" товаров
    * Сравнить результаты поиска по параметрам и по названию

#  Сценарий: Поиск клавиатур
#    * Выбрать категорию "Периферия" в главном меню
#    * Выбрать подкатегорию "Клавиатуры" в списке
#    * Выбрать производителя "A4Tech"
#    * Задать минимальную цену "2000" рублей
#    * Проверить, что на странице отображается не более "24" товаров
#    * Запомнить наименование первого товара в списке
#    * Выполнить поиск по сохраненному названию товара
#    * Проверить, что на странице отображается не более "1" товаров
#    * Сравнить результаты поиска по параметрам и по названию