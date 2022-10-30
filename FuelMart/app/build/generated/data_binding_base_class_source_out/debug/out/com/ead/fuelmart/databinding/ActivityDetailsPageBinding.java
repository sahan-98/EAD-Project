// Generated by view binder compiler. Do not edit!
package com.ead.fuelmart.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ead.fuelmart.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDetailsPageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button AddQue;

  @NonNull
  public final Button DieselButton;

  @NonNull
  public final Button PetrolButton;

  @NonNull
  public final TextView textAvDiesel;

  @NonNull
  public final TextView textAvPetrol;

  @NonNull
  public final TextView textDiesel;

  @NonNull
  public final TextView textPetrol;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView6;

  private ActivityDetailsPageBinding(@NonNull ConstraintLayout rootView, @NonNull Button AddQue,
      @NonNull Button DieselButton, @NonNull Button PetrolButton, @NonNull TextView textAvDiesel,
      @NonNull TextView textAvPetrol, @NonNull TextView textDiesel, @NonNull TextView textPetrol,
      @NonNull TextView textView2, @NonNull TextView textView6) {
    this.rootView = rootView;
    this.AddQue = AddQue;
    this.DieselButton = DieselButton;
    this.PetrolButton = PetrolButton;
    this.textAvDiesel = textAvDiesel;
    this.textAvPetrol = textAvPetrol;
    this.textDiesel = textDiesel;
    this.textPetrol = textPetrol;
    this.textView2 = textView2;
    this.textView6 = textView6;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetailsPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetailsPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_details_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetailsPageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.AddQue;
      Button AddQue = ViewBindings.findChildViewById(rootView, id);
      if (AddQue == null) {
        break missingId;
      }

      id = R.id.DieselButton;
      Button DieselButton = ViewBindings.findChildViewById(rootView, id);
      if (DieselButton == null) {
        break missingId;
      }

      id = R.id.PetrolButton;
      Button PetrolButton = ViewBindings.findChildViewById(rootView, id);
      if (PetrolButton == null) {
        break missingId;
      }

      id = R.id.textAvDiesel;
      TextView textAvDiesel = ViewBindings.findChildViewById(rootView, id);
      if (textAvDiesel == null) {
        break missingId;
      }

      id = R.id.textAvPetrol;
      TextView textAvPetrol = ViewBindings.findChildViewById(rootView, id);
      if (textAvPetrol == null) {
        break missingId;
      }

      id = R.id.textDiesel;
      TextView textDiesel = ViewBindings.findChildViewById(rootView, id);
      if (textDiesel == null) {
        break missingId;
      }

      id = R.id.textPetrol;
      TextView textPetrol = ViewBindings.findChildViewById(rootView, id);
      if (textPetrol == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      return new ActivityDetailsPageBinding((ConstraintLayout) rootView, AddQue, DieselButton,
          PetrolButton, textAvDiesel, textAvPetrol, textDiesel, textPetrol, textView2, textView6);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
