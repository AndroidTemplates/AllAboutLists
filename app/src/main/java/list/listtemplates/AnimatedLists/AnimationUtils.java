package list.listtemplates.AnimatedLists;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnticipateInterpolator;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/*import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;*/

/**
 * Created by CHANDRASAIMOHAN on 7/26/2016.
 */
public  class AnimationUtils {
    public static void animate(RecyclerView.ViewHolder holder, boolean goesDown) {

        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(holder.itemView, "scaleX" ,0.5F, 0.8F, 1.0F);
        ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(holder.itemView, "scaleY", 0.5F, 0.8F, 1.0F);
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY", goesDown == true ? 300 : -300, 0);
         ObjectAnimator animatorTranslateX = ObjectAnimator.ofFloat(holder.itemView, "translationX", -50, 50, -30, 30, -20, 20, -5, 5, 0);
        animatorSet.playTogether(animatorTranslateX, animatorTranslateY, animatorScaleX, animatorScaleY);
        animatorSet.setInterpolator(new AnticipateInterpolator());
        animatorSet.setDuration(1000);
        animatorSet.start();

    }
    public static void animateWithdaimajiaLibrary(RecyclerView.ViewHolder holder, boolean goesDown) {
        YoYo.with(Techniques.RubberBand)
                .duration(1000)
                .playOn(holder.itemView);
    }
}
