# fourLessons
приложение состоящее из четырех Activity. "Каталог","Карта","Поиск","Личный кабинет".
Внутри каждой активити объект TestModel реализующий интерфейс Parcelable 
который состоит из двух полей типа String и двух коллекций List<>. 
При старте каждой активити в onCreate методе должен рандомно заполнятся данный объект TestModel.
String значения необходимо выводить на экран. При повороте экрана состояние должно сохранятся и отображаемый текст не должен изменятся.

Каждая Activity должна уметь обрабатывать Intent c соответствующими урлами.

Каталог -> http://my.market.com/catalog
Карта -> http://my.market.com/map
Поиск -> http://my.market.com/search
Личный кабинет -> market://account

При этом по умолчанию при клике ссылки http://my.market.com пользователь должен переходить на экран Каталог.