package edu.charles_wyatt.shoppinglist.ui.mainmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.charles_wyatt.shoppinglist.R
import edu.charles_wyatt.shoppinglist.ui.viewshoppinglist.ListActivity
import kotlinx.android.synthetic.main.menu_screen.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_screen)

        val intent = Intent(this@MenuActivity, ListActivity::class.java)

        view_lists.setOnClickListener()
        {
            intent.putExtra("mode", 1)
            startActivity(intent)
        }
        new_list.setOnClickListener()
        {
//            Log.e("TAG", "Frag button pressed")
//            var otherfragment = supportFragmentManager.findFragmentById(R.id.frag_layout) as? AddItemFrag
//            if (otherfragment == null)
//            {
//                otherfragment = AddItemFrag()
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.frag_layout, otherfragment)
//                    .commit()
//            }
//            intent.putExtra("mode", 1)
//            startActivity(intent)
        }
        remove_list.setOnClickListener()
        {
            intent.putExtra("mode", 3)
            startActivity(intent)
        }
    }
}
