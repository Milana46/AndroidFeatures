package by.example.androidfeatures.Models

//базовый клаасс;
class PopularModel {

    private var foodImage: Int? = null
    private var foodName: String = ""
    private var foodPrice: Int = 0
    private var foodCount:Int=1


    constructor()

    constructor(foodImage: Int?, foodName: String, foodPrice: Int, foodCount:Int) {

        this.foodName = foodName
        this.foodPrice = foodPrice
        this.foodImage = foodImage
        this.foodCount=foodCount

    }

    fun getFoodCount():Int{
        return foodCount
    }

    fun getFoodImage(): Int? {
        return foodImage
    }

     fun getFoodPrice(): Int{
        return foodPrice
    }

     fun getFoodName(): String {
        return foodName;
    }

    fun setFoodCount(foodCount:Int){
        this.foodCount=foodCount
    }
     fun setFoodImage(foodImage: Int?) {
        this.foodImage = foodImage
    }

     fun setFoodPrice(foodPrice: Int) {
        this.foodPrice = foodPrice
    }

     fun setFoodName(foodName: String) {
        this.foodName = foodName
    }




}