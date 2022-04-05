package science.example.mybooks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainNavigationHostFragment) as? NavHostFragment
            ?: return
        val navController = findNavController(R.id.mainNavigationHostFragment)

        val mainBottomNavigationView = findViewById<BottomNavigationView>(R.id.mainBottomNavigationView)
        mainBottomNavigationView.setupWithNavController(navController)

        setupRecyclerView()
    }
    fun setupRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val BookAdapter = BookAdapter(generateList(10))
        recyclerView.adapter = BookAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun generateList(size: Int): List<book> {
        val list = mutableListOf<book>()

        for (i in 1..size) {
            list.add(generateBook(i))
        }
        return list
    }

    fun generateBook(i: Int): book {
        return when {
            i == 1 -> return book("Cесилия Ахерн", "Клеймо", R.drawable.kleimo)
            i == 2 -> return book("Cесилия Ахерн", "Идеал", R.drawable.ideal)
            i == 3 -> return book("Лев Николаевич Толстой", "Война и Мир", R.drawable.voina_i_mir)
            i == 4 -> return book("Федор Михайлович Достоевский", "Преступление и наказание", R.drawable.prestyplenie)
            i == 5 -> return book("Антуан деСент-Экзюпери", "Маленький Принц", R.drawable.malenkiiprins)
            i == 6 -> return book("Джордж Оруэлл", "1984", R.drawable.k1984)
            i == 7 -> return book("Михаил Афанасьевич Булгаков", "Мастер и Маргарита", R.drawable.master)
            i == 8 -> return book("Николай Васильевич Гоголь", "Тарас Бульба", R.drawable.taras)
            i == 9 -> return book("Александр Сергеевич Грибоедов", "Горе от ума", R.drawable.goreotyma)
            i == 10 -> return book("Максим Горький", "На дне", R.drawable.nadne)
            else -> return book("Автор", "Название", R.drawable.nobook)
        }
    }
}