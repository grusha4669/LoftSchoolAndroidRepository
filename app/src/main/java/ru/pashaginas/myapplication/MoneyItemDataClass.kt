package ru.pashaginas.myapplication

data class MoneyItemDataClass(val amount: Int, val purpose: String?)
//{
//    companion object {
//        fun getInstance(moneyRemoteItem: MoneyRemoteItem) : MoneyItemDataClass {
//            return MoneyItemDataClass(moneyRemoteItem.price.toString(), moneyRemoteItem.name)
//        }
//    }
//}
//not working yet