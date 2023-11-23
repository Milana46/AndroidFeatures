package by.example.androidfeatures.Models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.currentCoroutineContext


//Для сохранения данных, которые потом будут передаваться в CartFragment;
class SharedModel : ViewModel() {

    val cartItem= MutableLiveData<ArrayList<PopularModel>>()
    val buttonStates=ArrayList<Boolean>()

    fun fetButtonStates():List<Boolean>{
        return buttonStates
    }

    fun addToCart(item:PopularModel){
        val currentCartItem=cartItem.value?:ArrayList<PopularModel>()
        currentCartItem.add(item)
        cartItem.value=currentCartItem
        buttonStates.add(true)
    }

    fun deleteFromCart(item:PopularModel){
        val currentCartItem=cartItem.value?:ArrayList<PopularModel>()
        val index=currentCartItem.indexOf(item)
        //если индекс не выходит за границу, то удаляем элементы
        if(index!=-1){
            currentCartItem.removeAt(index)
            cartItem.value=currentCartItem
            buttonStates.removeAt(index)

        }
    }

    fun inList(item:PopularModel):Boolean{
        val currentCartItem=cartItem.value?:ArrayList<PopularModel>()
        return currentCartItem.contains(item)
    }





}