package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.matt.bitfit1.R
import com.matt.bitfit1.CurrentFood

class FoodListRecyclerViewAdapter(private val foods: MutableList<CurrentFood>)
    : RecyclerView.Adapter<FoodListRecyclerViewAdapter.FoodViewHolder>()
{

    override fun getItemCount() = foods.size

    inner class FoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
         val mfoodName: TextView
         val mfoodCalories: TextView
        init {
            mfoodName = itemView.findViewById(R.id.FoodName)
            mfoodCalories = itemView.findViewById(R.id.NumberOfCalories)
        }



        override fun onClick(p0: View?) {
            val food = foods[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.current_food_fragment, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foods[position]
        holder.mfoodName.text = food.foodName
        holder.mfoodCalories.text = food.foodCalories

        }
    }
