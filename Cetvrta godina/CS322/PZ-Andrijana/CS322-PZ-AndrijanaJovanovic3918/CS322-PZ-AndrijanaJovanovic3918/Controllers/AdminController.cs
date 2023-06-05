using CS322_PZ_AndrijanaJovanovic3918.Models;
using CS322_PZ_AndrijanaJovanovic3918.ViewModels;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;

namespace CS322_PZ_AndrijanaJovanovic3918.Controllers
{
    [Authorize(Roles ="Admin")]
    public class AdminController : Controller
    {
        private readonly IPieRepository _pieRepository;
        private readonly AppDbContext _appDbContext;
        [BindProperty]
        public Pie pie { get; set; }

        public AdminController(IPieRepository pieRepository, AppDbContext appDbContext)
        {
            _pieRepository = pieRepository;
            _appDbContext = appDbContext;
        }

        public IActionResult Index()
        {
            PiesListViewModel piesListViewModel = new PiesListViewModel();
            piesListViewModel.Pies = _pieRepository.AllPies;

            return View(piesListViewModel);
        }


        public IActionResult Delete(int pieId)
        {
            var selectedPie = _pieRepository.AllPies.FirstOrDefault(p => p.PieId == pieId);

            if (selectedPie != null)
            {

                _appDbContext.Pies.Remove(selectedPie);
                _appDbContext.SaveChanges();
                TempData["Success"] = "Delete success.";

            }
            else {
                TempData["Error"] = "Delete failed. Try again, and if the problem persists see your system administrator.";
            }

            return RedirectToAction("Index");
        }

        public IActionResult Upsert(int? pieId)
        {
            pie = new Pie();

            if (pieId == null)
            {
                //create
                return View(pie);
            }

            //update
            pie = _appDbContext.Pies.FirstOrDefault(p => p.PieId == pieId);
            if (pie == null)
            {
                return NotFound();
            }

            return View(pie);
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Upsert()
        {
            if (ModelState.IsValid)
            {
                if (pie.PieId == 0)
                {
                    //create
                    _appDbContext.Pies.Add(pie);
                }
                else
                {
                    //update
                    _appDbContext.Pies.Update(pie);
                }
                _appDbContext.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(pie);
        }

    }
}
