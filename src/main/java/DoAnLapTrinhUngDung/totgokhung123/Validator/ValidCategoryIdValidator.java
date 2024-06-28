package DoAnLapTrinhUngDung.totgokhung123.Validator;

import DoAnLapTrinhUngDung.totgokhung123.entity.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category>
{
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext constraintValidatorContext)
    {
        return category != null && category.getId() != null;
    }
}