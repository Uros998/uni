using CS322_PZ_AndrijanaJovanovic3918.Models;
using CS322_PZ_AndrijanaJovanovic3918.ViewModels;
using Microsoft.AspNetCore.Mvc;

namespace CS322_PZ_AndrijanaJovanovic3918.Controllers
{
    public class PieController : Controller
    {
        private readonly IPieRepository _pieRepository;

        public PieController(IPieRepository pieRepository)
        {
            _pieRepository = pieRepository;
        }

        public ViewResult List() 
        {
            PiesListViewModel piesListViewModel = new PiesListViewModel();
            piesListViewModel.Pies = _pieRepository.AllPies;

            piesListViewModel.CurrentCategory = "Cheese cakes";
            return View(piesListViewModel);
        }

        public IActionResult Details(int id)
        {
            var pie = _pieRepository.GetPieById(id);
            if (pie == null)
                return NotFound();

            return View(pie);
        }


    }
}
