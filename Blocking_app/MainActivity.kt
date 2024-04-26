import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the ListView in your layout
        val listView = findViewById<ListView>(R.id.listView)

        // Retrieve the list of installed packages
        val packageManager = packageManager
        val packages = packageManager.getInstalledPackages(0)

        // Extract the application names from the PackageInfo objects
        val appNames = packages.map { packageInfo ->
            packageManager.getApplicationLabel(packageInfo.applicationInfo).toString()
        }

        // Create an ArrayAdapter to display the app names in the ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, appNames)
        listView.adapter = adapter
    }
}
