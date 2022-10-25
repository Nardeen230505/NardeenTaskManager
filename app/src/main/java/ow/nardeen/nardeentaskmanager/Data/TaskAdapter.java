package ow.nardeen.nardeentaskmanager.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ow.nardeen.nardeentaskmanager.R;

// وسيط من نوع مهمات
public class TaskAdapter extends ArrayAdapter<Mahama> //تخصيص الوسيط (الادابتر) بس لنوع المهمات
    // الادابتر هو المركز هو الي بنعطيه معطيات وبعرضهن
    // يعني بالفاير بيس في معطيات هاد الادابتر بوخد المعطيات من الفاير بيس وبعرضهن
    // تخزين المهام الي هي عبارة عن كائنات بمبنى معطيات الي هي مصفوفة من نوع مهمة
{
    public TaskAdapter(@NonNull Context context)
    {
        super(context, R.layout.task_item);

    }
    // عرض معطيات بالواجهة

    //

    @NonNull
    @Override
    // position - رقم المهمة
    // parent - الي بحوي هاد الايتم
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent ) {

        // بناء  واجهةالي بتعرض المهمة - item
        View vItem= LayoutInflater.from(getContext()).inflate(R.layout.task_item , parent , false);
        TextView tvTitle=vItem.findViewById(R.id.tvTitle);
        TextView tvSubject=vItem.findViewById(R.id.tvSubject);
        RatingBar rating = vItem.findViewById(R.id.rating);
        CheckBox cbIsCompleted=vItem.findViewById(R.id.cbIsCompleted);
        ImageButton imgButton=vItem.findViewById(R.id.imgButton);

        // باخد القيم تبعت المهمة وبحطهن بالحقول
        final Mahama mahama=getItem(position); //عملت كائن وبدي استخرج القيم الي الو عن طريق الposition الي الو
        // بناء الكائن بهدف استخراج القيم من الحقول
        tvTitle.setText(mahama.getTitle()); //استخراج قيمة ال text من الحقل وتحديثها
        tvSubject.setText(mahama.getSubject());
        rating.setRating(mahama.getImportance());
        cbIsCompleted.setChecked(false);

        //get - بتستخرج القيمة من الحقل
        // set - يتم تحديث الصفة

        return vItem;

        // checkbox عشان نفحص اذا المهمة تمت

    }
}
