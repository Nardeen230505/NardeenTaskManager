package ow.nardeen.nardeentaskmanager.Data;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.security.PublicKey;

import ow.nardeen.nardeentaskmanager.R;

public class TaskAdapter extends ArrayAdapter
    // الادابتر هو المركز هو الي بنعطيه معطيات وبعرضهن
    // يعني بالفاير بيس في معطيات هاد الادابتر بوخد المعطيات من الفاير بيس وبعرضهن
    // تخزين المهام الي هي عبارة عن كائنات بمبنى معطيات الي هي مصفوفة من نوع مهمة
{
    public TaskAdapter(@NonNull Context context)
    {
        super(context, R.layout.task_item);

    }
    // عرض معطيات بالواجهة


    @NonNull
    @Override
    // position - رقم المهمة
    // parent - الي بحوي هاد الايتم
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent ) {
        return super.getView(position, convertView, parent);
    }
}
