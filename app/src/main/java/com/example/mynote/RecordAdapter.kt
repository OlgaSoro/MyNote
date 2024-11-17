import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynote.R


class RecordAdapter (private val record:MutableList<String>):
    RecyclerView.Adapter<RecordAdapter.RecordViewHolder>(){
    class RecordViewHolder(item:View):RecyclerView.ViewHolder(item){
        val record:TextView=item.findViewById(R.id.itemrecordtv)
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): RecordViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_record,parent,false)
        return RecordViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.record.text=record[position]
    }

    override fun getItemCount(): Int {
        return record.size
    }

    fun addrecord(record1:String){
        record.add(record1)
        notifyItemInserted(record.size-1)

    }


    }


