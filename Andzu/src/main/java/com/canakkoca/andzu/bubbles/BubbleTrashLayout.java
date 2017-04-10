package com.canakkoca.andzu.bubbles;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;

import com.canakkoca.andzu.R;


class BubbleTrashLayout extends BubbleBaseLayout {

    public static final int VIBRATION_DURATION_IN_MS = 70;
    private boolean magnetismApplied = false;
    private boolean attachedToWindow = false;

    public BubbleTrashLayout(Context context) {
        super(context);
    }

    public BubbleTrashLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BubbleTrashLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        attachedToWindow = true;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        attachedToWindow = false;
    }

    @Override
    public void setVisibility(int visibility) {
        if (attachedToWindow) {
            if (visibility != getVisibility()) {
                if (visibility == VISIBLE) {
                    playAnimation(R.animator.bubble_trash_shown_animator);


                } else {
                    playAnimation(R.animator.bubble_trash_hide_animator);
                }
            }
        }
        super.setVisibility(visibility);
    }

    void applyMagnetism() {
        if (!magnetismApplied) {
            magnetismApplied = true;
            playAnimation(R.animator.bubble_trash_shown_magnetism_animator);
        }
    }

    void vibrate() {
        final Vibrator vibrator = (Vibrator)getContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(VIBRATION_DURATION_IN_MS);
    }

    void releaseMagnetism() {
        if (magnetismApplied) {
            magnetismApplied = false;
            playAnimation(R.animator.bubble_trash_hide_magnetism_animator);
        }
    }

    private void playAnimation(int animationResourceId) {
        if (!isInEditMode()) {
            AnimatorSet animator = (AnimatorSet) AnimatorInflater
                    .loadAnimator(getContext(), animationResourceId);
            animator.setTarget(getChildAt(0));
            animator.start();
        }
    }
}