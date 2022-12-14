// Generated by view binder compiler. Do not edit!
package com.ead.fuelmart.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ead.fuelmart.R;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySignUpBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText TextUserEmailAddress1;

  @NonNull
  public final EditText TextUserName;

  @NonNull
  public final EditText TextUserPassword1;

  @NonNull
  public final EditText TextUserRePassword;

  @NonNull
  public final EditText TextVehicleNumber;

  @NonNull
  public final AppBarLayout appBarLayout2;

  @NonNull
  public final Button buttonSignUp;

  @NonNull
  public final ConstraintLayout coordinatorLayout2;

  @NonNull
  public final Spinner spinnerFuelType;

  @NonNull
  public final Spinner spinnerVehicleType;

  @NonNull
  public final TextView textView;

  @NonNull
  public final Toolbar toolbar;

  private ActivitySignUpBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText TextUserEmailAddress1, @NonNull EditText TextUserName,
      @NonNull EditText TextUserPassword1, @NonNull EditText TextUserRePassword,
      @NonNull EditText TextVehicleNumber, @NonNull AppBarLayout appBarLayout2,
      @NonNull Button buttonSignUp, @NonNull ConstraintLayout coordinatorLayout2,
      @NonNull Spinner spinnerFuelType, @NonNull Spinner spinnerVehicleType,
      @NonNull TextView textView, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.TextUserEmailAddress1 = TextUserEmailAddress1;
    this.TextUserName = TextUserName;
    this.TextUserPassword1 = TextUserPassword1;
    this.TextUserRePassword = TextUserRePassword;
    this.TextVehicleNumber = TextVehicleNumber;
    this.appBarLayout2 = appBarLayout2;
    this.buttonSignUp = buttonSignUp;
    this.coordinatorLayout2 = coordinatorLayout2;
    this.spinnerFuelType = spinnerFuelType;
    this.spinnerVehicleType = spinnerVehicleType;
    this.textView = textView;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_sign_up, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySignUpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.TextUserEmailAddress1;
      EditText TextUserEmailAddress1 = ViewBindings.findChildViewById(rootView, id);
      if (TextUserEmailAddress1 == null) {
        break missingId;
      }

      id = R.id.TextUserName;
      EditText TextUserName = ViewBindings.findChildViewById(rootView, id);
      if (TextUserName == null) {
        break missingId;
      }

      id = R.id.TextUserPassword1;
      EditText TextUserPassword1 = ViewBindings.findChildViewById(rootView, id);
      if (TextUserPassword1 == null) {
        break missingId;
      }

      id = R.id.TextUserRePassword;
      EditText TextUserRePassword = ViewBindings.findChildViewById(rootView, id);
      if (TextUserRePassword == null) {
        break missingId;
      }

      id = R.id.TextVehicleNumber;
      EditText TextVehicleNumber = ViewBindings.findChildViewById(rootView, id);
      if (TextVehicleNumber == null) {
        break missingId;
      }

      id = R.id.appBarLayout2;
      AppBarLayout appBarLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (appBarLayout2 == null) {
        break missingId;
      }

      id = R.id.buttonSignUp;
      Button buttonSignUp = ViewBindings.findChildViewById(rootView, id);
      if (buttonSignUp == null) {
        break missingId;
      }

      ConstraintLayout coordinatorLayout2 = (ConstraintLayout) rootView;

      id = R.id.spinnerFuelType;
      Spinner spinnerFuelType = ViewBindings.findChildViewById(rootView, id);
      if (spinnerFuelType == null) {
        break missingId;
      }

      id = R.id.spinnerVehicleType;
      Spinner spinnerVehicleType = ViewBindings.findChildViewById(rootView, id);
      if (spinnerVehicleType == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new ActivitySignUpBinding((ConstraintLayout) rootView, TextUserEmailAddress1,
          TextUserName, TextUserPassword1, TextUserRePassword, TextVehicleNumber, appBarLayout2,
          buttonSignUp, coordinatorLayout2, spinnerFuelType, spinnerVehicleType, textView, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
