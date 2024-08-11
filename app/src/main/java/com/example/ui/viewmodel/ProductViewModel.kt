package com.example.ui.viewmodel

import android.net.http.HttpException
import android.os.Build
import android.os.ext.SdkExtensions
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.Product
import com.example.data.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products
    private val repository = ProductRepository()

    fun fetchProducts() {
        viewModelScope.launch {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(
                    Build.VERSION_CODES.S) >= 7) {
                try {
                    val response = repository.fetchProducts("example", 2)
                    if (response.status.statusCode == 0) {
                        _products.value = response.plpResults.records
                    } else {
                        Log.e("ProductViewModel", "Error: ${response.status.statusCode}, ${response.status}")
                    }
                } catch (e: HttpException) {
                    Log.e("ProductViewModel", "HttpException: ${e.message}", e)
                } catch (e: Exception) {
                    Log.e("ProductViewModel", "Exception: ${e.message}", e)
                }
            }
        }
    }
}




