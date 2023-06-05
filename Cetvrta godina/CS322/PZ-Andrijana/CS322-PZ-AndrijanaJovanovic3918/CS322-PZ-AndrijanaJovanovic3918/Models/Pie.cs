using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace CS322_PZ_AndrijanaJovanovic3918.Models
{
    public class Pie
    {
        public int PieId { get; set; }

        [Required(ErrorMessage = "Please enter name")]
        [StringLength(50)]
        public string Name { get; set; }

        [Required(ErrorMessage = "Please enter short description")]
        [Display(Name = "Short Description")]
        [StringLength(50)]
        public string ShortDescription { get; set; }

        [Required(ErrorMessage = "Please enter long description")]
        [Display(Name = "Long Description")]
        [StringLength(500)]
        public string LongDescription { get; set; }

        [Display(Name = "Allergy Information")]
        [StringLength(50)]
        public string AllergyInformation { get; set; }

        [Required(ErrorMessage = "Please enter price")]
        [Display(Name = "Price")]
        public decimal Price { get; set; }

        [Required(ErrorMessage = "Please enter your first name")]
        [Display(Name = "Image Url")]
        [StringLength(500)]
        public string ImageUrl { get; set; }

        [Display(Name = "Image ThumbnailUrl")]
        [StringLength(500)]
        public string ImageThumbnailUrl { get; set; }

        [Required(ErrorMessage = "Please enter is pie of the week")]
        [Display(Name = "Is Pie Of The Week")]
        public bool IsPieOfTheWeek { get; set; }

        [Required(ErrorMessage = "Please enter in stock")]
        [Display(Name = "In Stock")]
        public bool InStock { get; set; }

        [Required(ErrorMessage = "Please enter your first name")]
        [Display(Name = "Category")]
        public int CategoryId { get; set; }

        public Category Category { get; set; }

    }
}
