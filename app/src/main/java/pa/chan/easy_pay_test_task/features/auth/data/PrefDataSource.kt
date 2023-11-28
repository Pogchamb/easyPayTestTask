package pa.chan.easy_pay_test_task.features.auth.data

import android.content.SharedPreferences
import javax.inject.Inject

class PrefDataSource @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    fun setUserToken(token: String) {
        sharedPreferences.edit()
            .putString("UserToken", token)
            .apply()
    }

    fun getUserToken(): String? {
        return sharedPreferences.getString("UserToken", "")
    }

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }
}